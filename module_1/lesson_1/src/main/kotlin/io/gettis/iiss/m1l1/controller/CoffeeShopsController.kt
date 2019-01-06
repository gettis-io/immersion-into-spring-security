package io.gettis.iiss.m1l1.controller

import io.gettis.iiss.m1l1.model.CoffeeShop
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coffeeShops")
class CoffeeShopsController {

    @GetMapping("")
    fun getAll(): List<CoffeeShop> {
        return listOf(
                CoffeeShop("Best Coffee")
        )
    }

}