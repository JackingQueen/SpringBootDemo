package com.example.demo.controller;

import com.example.demo.entity.Car;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/car")
@Validated
public class CarController {

    @RequestMapping("/findone")
    public Car findOneCar() {
        Car car = new Car(1, "toyo", 1999.99F, new Date(), "", "","jtzn@foxmail.com");
        return car;
    }

    @RequestMapping("/getall")
    public List<Car> getAll(){
        List<Car> list=new ArrayList<Car>();
        Car car1 = new Car(1, "toyo", 1999.99F,new Date(),"","","jtznenic@foxmail.com");
        Car car2= new Car(2, "dazhong", 2999.99F,new Date(),"","","jtznenic@163.com");
        Car car3 = new Car(3, "fengtian", 3999.99F,new Date(),"","","jtznenic@126.com");
        Car car4 = new Car(4, "benchi", 4999.99F,new Date(),"","","jtznenic@outlook.com");

        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);

        return list;

    }

    // @RequestParam   获取查询参数。即url?name=value这种形式
    // @PathVariable    获取路径参数。即url/{id}这种形式

    @RequestMapping("/getcar2/{name}")
    public Car getCarById(@RequestParam(name="id") Integer id, @PathVariable(name="name") String name) {
        Car car = new Car();
        car.setId(id);
        car.setName(name);
        car.setPrice(100000.99F);
        car.setCreatedate(new Date());
        return car;
    }

    @RequestMapping("/getcar3")
    public Car getCarById(@RequestBody Car car) {

        return car;
    }

    // @InitBinder用来格式化request请求中字符串（2018-01-19 17:25:29）为日期时间类型
    /*@InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/getcar4")
    public Car getCarById(Car car) {
        return car;
    }*/

    @RequestMapping("/valid/{group:[a-zA-Z0-9_]+}/{userid}")
    public String valid1(@PathVariable("group") String group,
                         @PathVariable("userid") String userid){
        return group+":"+userid;
    }

    @RequestMapping("/valid2")
    public String param(@NotBlank(message = "group不能为空")
                        @RequestParam("group") String group,

                        @NotBlank(message = "email不能为空")
                        @Email(message="不符合邮箱规格")
                        @RequestParam("email") String email) {
        return group + ":" + email;
    }
}
