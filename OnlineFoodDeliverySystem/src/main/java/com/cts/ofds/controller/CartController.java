package com.cts.ofds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ofds.model.Cart;

import com.cts.ofds.model.Dish;
import com.cts.ofds.service.CartService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/getAllByUser/{id}")
	public List<Cart> getAllByUser(@PathVariable("id") String userId){
		return cartService.getAllByUserId(userId);
	}
	
	@GetMapping("/get/{cID}")
	public Cart get(@PathVariable("cID") int cID){
		return cartService.get(cID);
	}
	
	@PostMapping("/add")
	public boolean add(@RequestBody Cart cart)
	{
		return cartService.add(cart);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return cartService.delete(id);
	}
	
	@DeleteMapping("/deleteAllByUser/{userId}")
	public boolean deleteAllByUser(@PathVariable("userId") String UserId) {
		return cartService.deleteAllByUserId(UserId);
	}
	
	@GetMapping("/addItem/{cID}")
	public boolean addItem(@PathVariable("cID") int cID) {
		return cartService.addItem(cID);
	}
	
	@DeleteMapping("/removeItem/{cID}")
	public boolean removeItem(@PathVariable("cID") int cID) {
		return cartService.removeItem(cID);
	}
	
	@PostMapping("/addToCart/{userId}")
	public boolean addToCart(@PathVariable("userId") String userId,@RequestBody Dish dish) {
		return cartService.addToCart(userId, dish);
	}
	
	@PostMapping("/removeFromCart/{userId}")
	public boolean removeFromCart(@PathVariable("userId") String userId,@RequestBody Dish dish) {
		return cartService.removeFromCart(userId, dish);
	}

}
