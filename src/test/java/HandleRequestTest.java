import API.CPUExecutor;
import API.arraySorting.HandleRequest;
import API.model.Algorithm;
import API.model.RequestData;
import API.model.RequestResult;
import API.model.Result;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;

public class HandleRequestTest {

    @Test
    public void test() {
        HandleRequest handleRequest = new HandleRequest( new RequestData(1000, 5000, 100, Algorithm.QUICK_SORT, LocalDateTime.now()));
        Future<RequestResult> res = CPUExecutor.getInstance().getExecutor().submit(handleRequest);
        try {
            RequestResult results = res.get();
            System.out.println(results);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
