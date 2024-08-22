package io.knifer.freebox.util;

import com.lzy.okgo.request.GetRequest;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class HttpUtil {

    private HttpUtil() {
        throw new UnsupportedOperationException();
    }

    public static String getStringBody(GetRequest<String> request) {
        ResponseBody body;

        try(Response resp = request.execute();) {
            body = resp.body();
            if (body == null) {
                return null;
            }

            return body.string();
        } catch (IOException e) {
            return null;
        }
    }
}
