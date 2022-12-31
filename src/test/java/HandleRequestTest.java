import API.CPUExecutor;
import API.arraySorting.HandleRequest;
import API.model.Algorithm;
import API.model.RequestData;
import API.model.Result;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Future;

public class HandleRequestTest {

    @Test
    public void test() {
        HandleRequest handleRequest = new HandleRequest( new RequestData(1000, 5000, 100, 1000L, Algorithm.QUICK_SORT, false));
        Future<List<Result>> res = CPUExecutor.getInstance().getExecutor().submit(handleRequest);
        try {
            List<Result> results = res.get();
            System.out.println(results);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
