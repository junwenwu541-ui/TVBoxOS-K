package io.knifer.freebox.ui.dialog;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.tvbox.osc.R;
import com.github.tvbox.osc.callback.LoadingCallback;
import com.github.tvbox.osc.ui.dialog.BaseDialog;
import com.github.tvbox.osc.util.HawkConfig;
import com.github.tvbox.osc.util.LocalIPAddress;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.lzy.okgo.OkGo;
import com.orhanobut.hawk.Hawk;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import io.knifer.freebox.constant.FreeBoxConstants;
import io.knifer.freebox.model.common.PairingInfo;
import io.knifer.freebox.ui.listener.DialogChangeListener;
import io.knifer.freebox.util.GsonUtil;
import io.knifer.freebox.websocket.WSHelper;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PairingDialog extends BaseDialog implements ChangeableDialog {

    private LoadService<?> loadService;

    private final DialogChangeListener listener;

    private final TextView tvAddressForFreeBox;
    private final TextView freeBoxServiceSearch;
    private final LinearLayout freeBoxConnectLayout;
    private final EditText freeBoxServiceHttpPortInput;
    private final EditText freeBoxServiceAddressInput;
    private final EditText freeBoxServicePortInput;

    public PairingDialog(@NonNull Context context, @Nullable DialogChangeListener listener) {
        super(context);
        String localIp;

        this.listener = listener;
        setContentView(R.layout.dialog_free_box_pairing);
        setCanceledOnTouchOutside(false);

        tvAddressForFreeBox = findViewById(R.id.tvAddressForFreeBox);
        freeBoxServiceSearch = findViewById(R.id.freeBoxServiceSearch);
        freeBoxConnectLayout = findViewById(R.id.freeBoxConnectLayout);
        freeBoxServiceHttpPortInput = findViewById(R.id.freeBoxServiceHttpPortInput);
        freeBoxServiceAddressInput = findViewById(R.id.freeBoxServiceAddressInput);
        freeBoxServicePortInput = findViewById(R.id.freeBoxServicePortInput);

        localIp = LocalIPAddress.getLocalIPAddress(this.getContext());
        tvAddressForFreeBox.setText(String.format("本机地址: %s", localIp));
        freeBoxServiceHttpPortInput.setText(String.valueOf(Hawk.get(
                HawkConfig.FREE_BOX_HTTP_SERVICE_PORT, FreeBoxConstants.DEFAULT_FREE_BOX_HTTP_PORT
        )));
        freeBoxServiceHttpPortInput.setCursorVisible(false);
        freeBoxServiceAddressInput.setText(Hawk.get(
                HawkConfig.FREE_BOX_SERVICE_ADDRESS, StringUtils.EMPTY
        ));
        freeBoxServiceAddressInput.setCursorVisible(false);
        freeBoxServicePortInput.setText(String.valueOf(Hawk.get(
                HawkConfig.FREE_BOX_SERVICE_PORT, StringUtils.EMPTY
        )));
        freeBoxServicePortInput.setCursorVisible(false);

        // FreeBox服务搜索触发
        freeBoxServiceSearch.setOnClickListener((view) -> {
            String port = freeBoxServiceHttpPortInput.getText().toString();

            showLoading();
            freeBoxServiceSearch.setEnabled(false);
            Toast.makeText(context, "开始搜索FreeBox服务，请耐心等待...", Toast.LENGTH_SHORT).show();
            new Thread(() -> {
                int divisionIp = localIp.lastIndexOf(".");
                String substring = localIp.substring(0, divisionIp + 1);
                ResponseBody body;
                PairingInfo pairingInfo;

                for (int i = 1; i < 255; i++) {
                    try (Response resp = OkGo.get(
                            "http://" + substring + i + ":" + port + "/pairing/tvbox"
                    ).execute()) {
                        body = resp.body();
                        if (body != null) {
                            pairingInfo = GsonUtil.fromJson(body.string(), PairingInfo.class);
                            String address = pairingInfo.getAddress();
                            Integer servicePort = pairingInfo.getPort();
                            if (address != null) {
                                view.post(() -> {
                                    loadService.showSuccess();
                                    freeBoxServiceSearch.setEnabled(true);
                                    freeBoxServiceAddressInput.setText(address);
                                    freeBoxServicePortInput.setText(String.valueOf(servicePort));
                                    Toast.makeText(
                                            context, "已找到可用服务", Toast.LENGTH_SHORT
                                    ).show();
                                });
                                return;
                            }
                        }
                    } catch (IOException ignored) {}
                }
                // 搜索结束，未找到结果
                view.post(() -> {
                    loadService.showSuccess();
                    freeBoxServiceSearch.setEnabled(true);
                });
            }).start();
        });

        // FreeBox服务连接触发
        findViewById(R.id.freeBoxServiceConnect).setOnClickListener((view) -> {
            if (
                    freeBoxServiceAddressInput.getText().length() == 0 ||
                            freeBoxServicePortInput.getText().length() == 0
            ) {
                return;
            }
            showLoading();
            Toast.makeText(context, "FreeBox配对中...", Toast.LENGTH_SHORT).show();
            new Thread(() -> {
                boolean success;
                int httpPort;
                String address;
                int port;

                if (WSHelper.isOpen()) {
                    WSHelper.closeBlocking();
                }
                httpPort = Integer.parseInt(freeBoxServiceHttpPortInput.getText().toString());
                address = freeBoxServiceAddressInput.getText().toString();
                port = Integer.parseInt(freeBoxServicePortInput.getText().toString());
                success = WSHelper.connectBlocking(address, port, false);
                if (success) {
                    Hawk.put(HawkConfig.FREE_BOX_HTTP_SERVICE_PORT, httpPort);
                    Hawk.put(HawkConfig.FREE_BOX_SERVICE_ADDRESS, address);
                    Hawk.put(HawkConfig.FREE_BOX_SERVICE_PORT, port);
                    view.post(() -> {
                        Toast.makeText(
                                context, "配对成功", Toast.LENGTH_SHORT
                        ).show();
                        onChange();
                        loadService.showSuccess();
                        dismiss();
                    });
                } else {
                    view.post(() -> {
                        Toast.makeText(
                                context, "配对失败", Toast.LENGTH_SHORT
                        ).show();
                        loadService.showSuccess();
                    });
                }
            }).start();
        });

        // FreeBox断开触发
        findViewById(R.id.freeBoxServiceDisConnect).setOnClickListener(view -> {
            if (!WSHelper.isOpen()) {
                return;
            }
            showLoading();
            new Thread(() -> {
                WSHelper.closeBlocking();
                view.post(() -> {
                    Toast.makeText(
                            context, "已断开配对", Toast.LENGTH_SHORT
                    ).show();
                    loadService.showSuccess();
                    onChange();
                });
            }).start();
        });
    }

    private void showLoading() {
        if (loadService == null) {
            loadService = LoadSir.getDefault().register(
                    freeBoxConnectLayout, (Callback.OnReloadListener) v -> {});
        }
        loadService.showCallback(LoadingCallback.class);
    }

    @Override
    public void onChange() {
        if (listener != null) {
            listener.onChange();
        }
    }
}