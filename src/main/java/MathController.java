import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MathController {
    @GetMapping("/add/3/and/4")
    @ResponseBody
    public int addTwoNumbers(){
        return 3 + 7;
    }
}
