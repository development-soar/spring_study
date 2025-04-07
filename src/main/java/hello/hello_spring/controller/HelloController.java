package hello.hello_spring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController { // HelloController 클래스가 컨트롤러 역할을 함

    @GetMapping("hello")  // 클라이언트가 /hello 경로로 GET 요청을 보냈을 때 이 메소드 실행
    public String hello(Model model){
        model.addAttribute("data","hello!!"); // 템플릿엔진에서 ${data}로 사용 가능
        return "hello"; // 이 메소드 실행 후 hello.html 템플릿이 렌더링됨
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 응답 body에 직접 데이터를 넣어서 전달하겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
