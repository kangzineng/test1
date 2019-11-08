package com.shop.web;

import com.shop.domain.Customer;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> productList = productService.getProductList();
		modelAndView.addObject("productList", productList);
		modelAndView.setViewName("productList");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/itemEdit/{id}") public ModelAndView
	 * getProductById(@PathVariable("id") String id, HttpServletRequest request) {
	 * // String id = request.getParameter("id"); Product product =
	 * this.productService .getProductById(id != null && !id.equals("") ?
	 * Integer.parseInt(id) : null); ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.addObject("item", product);
	 * modelAndView.setViewName("productItem"); return modelAndView; }
	 * 
	 * 
	 * @RequestMapping(value = "/updateitem.action") public ModelAndView
	 * updateItem(String id, String name, float price, String detail){ Product
	 * product = new Product();
	 * product.setId(id!=null&&!id.equals("")?Integer.parseInt(id):null);
	 * product.setName(name); product.setPrice(price); product.setDetail(detail);
	 * product.setCreatetime(new Date()); this.productService.updateItem(product);
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("test"); return modelAndView; }
	 * 
	 * 
	 * // 上传图片
	 * 
	 * @RequestMapping(value = "/updateitem.action") public ModelAndView
	 * updateItem(Product product, MultipartFile pictureFile) throws IOException {
	 * // 取出图片的原名称 String Filename = pictureFile.getOriginalFilename();
	 * System.out.println("originalFilename------" + Filename); // 生成随机字符串组成新名称
	 * String NewFilename = UUID.randomUUID().toString() +
	 * Filename.substring(Filename.lastIndexOf("."));
	 * System.out.println("NewFilename----" + NewFilename); // 将图片保存到硬盘
	 * pictureFile.transferTo(new File("D:\\upload\\temp\\img\\" + NewFilename)); //
	 * 将图片保存到数据库 product.setPic(NewFilename);
	 * 
	 * this.productService.updateItem(product); ModelAndView modelAndView = new
	 * ModelAndView(); modelAndView.setViewName("test"); return modelAndView; }
	 * 
	 * @RequestMapping(value = "/queryitem.action") public ModelAndView
	 * queryItem(Customer customer) { System.out.println("customer:" + customer);
	 * return null; }
	 * 
	 * @RequestMapping(value = "/deleteitem.action") public ModelAndView
	 * deleteItem(Customer customer) { System.out.println(customer); return null; }
	 * 
	 * // 批量修改，把表格加入文本框
	 * 
	 * @RequestMapping(value = "/updateAllItem.action") public ModelAndView
	 * updateAllItem(Customer customer) { System.out.println(customer); return null;
	 * }
	 * 
	 * // String 返回类型
	 * 
	 * @RequestMapping(value = "/demo1") public String test1() { return "test"; }
	 * 
	 * @RequestMapping(value = "/demo2") public String test2(Model model) {
	 * model.addAttribute("name", "啊哈哈"); return "test"; }
	 * 
	 * // 转发
	 * 
	 * @RequestMapping(value = "/demo3") public String test3() { return
	 * "forward:/product"; }
	 * 
	 * // 重定向
	 * 
	 * @RequestMapping(value = "/demo4") public String test4() { return
	 * "redirect:/product"; }
	 * 
	 * // 测试全局异常
	 * 
	 * @RequestMapping(value = "/demo5") public String test5() { int i = 1 / 0;
	 * return "redirect:/product"; }
	 * 
	 * 
	 * //测试自定义异常
	 * 
	 * @RequestMapping(value = "/demo6") public String test6() throws MyException {
	 * if(true){ throw new MyException("自定义异常"); }
	 * 
	 * return "redirect:/product"; }
	 */

}
