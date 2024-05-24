package com.ot.main.productmanagement.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.delivery.data.dto.DeliveryCreateRequestDTO;
import com.ot.main.delivery.service.DeliveryService;
import com.ot.main.productmanagement.controller.ProductManagementController;
import com.ot.main.productmanagement.data.dto.MainToShopDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCompareResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCreateResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectListResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectOneResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementUpdateResponseDTO;
import com.ot.main.productmanagement.data.dto.ShopToMainResponseDTO;
import com.ot.main.productmanagement.service.ProductManagementService;

@RestController
@RequestMapping(value = "/api/v1/main-fulfillment")
public class ProductManagementControllerImpl implements ProductManagementController {

   private final ProductManagementService productManagementService;
   private final DeliveryService deliveryService;
   
   @Autowired
   public ProductManagementControllerImpl(ProductManagementService productManagementService, DeliveryService deliveryService) {
      this.productManagementService = productManagementService;
      this.deliveryService = deliveryService;
   }

   // 재고 생성
   @PostMapping("/createStock")
   @Override
   public ModelAndView createStock(@RequestParam String productCode) {

      ModelAndView mav = new ModelAndView();
      
      ProductManagementCreateResponseDTO createProduct = productManagementService.createStock(productCode);
      mav.addObject("createProduct" , createProduct);
      mav.setViewName("redirect:/api/v1/main-fulfillment/lookUpStock");

      return mav;
   }

   // 재고수정
   @PutMapping("/modifyInStock")
   @Override
   public ResponseEntity<ProductManagementUpdateResponseDTO> modifyInStock(String productCode, boolean inStatus,
         Integer inStock) {

      ProductManagementUpdateResponseDTO updateProduct = productManagementService.modifyInStock(productCode, inStatus,
            inStock);
      System.out.println("============updateProduct  : " + updateProduct + "================");

      return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
   }
   
   // 재고수정
      @PutMapping("/modifyOutStock")
      @Override
      public ResponseEntity<ProductManagementUpdateResponseDTO> modifyOutStock(String productCode, boolean outStatus, 
            Integer outStock) {

         ProductManagementUpdateResponseDTO updateProduct = productManagementService.modifyOutStock(productCode, outStatus, outStock);
   
         System.out.println("============updateProduct  : " + updateProduct + "================");

         return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
      }

   // 재고 상세보기
   @GetMapping("/selectStockDetail")
   @Override
   public ModelAndView selectStockDetail(Long id) {

      ModelAndView mav = new ModelAndView();
      
      ProductManagementSelectOneResponseDTO oneStock = productManagementService.selectStockDetail(id);
      System.out.println("oneStock : " + oneStock);
      
      mav.addObject("oneStock",oneStock);
      mav.setViewName("/productManagement/productManagement_Detail");
       return mav;
   }

   // 재고목록 조회
   @GetMapping("/lookUpStock")
   @Override
   public ModelAndView selectStockList() {
      ModelAndView mav = new ModelAndView();
      
      List<ProductManagementSelectListResponseDTO> stockList = productManagementService.selectStockList();
      System.err.println("stockList : " +  stockList);
      
      mav.addObject("stockList", stockList);
      mav.setViewName("/productManagement/productManagement_List");
      return mav;
   }

   // 안전재고 , 보유 재고 비교
   @GetMapping("/compareStockAndSafetyStock")
   @Override
   public void compareStockAndSafetyStock(String productCode) {
      ProductManagementCompareResponseDTO productManagementCompareResponseDTO = productManagementService.compareStockAndSafetyStock(productCode);
   }

   //create창으로 이동
   @GetMapping("/goToCreateStock")
   @Override
   public ModelAndView goToCreateStock() {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/productManagement/productManagement_create");
      return mav;
   }


   
   // 서버로부터 주문정보를 받아옴 
   
   // 주문정보를 세션에다가 때려박음 
   
   /*
   public 서버통신(){
      서버통신 -> 데이터 
      Session session = new Session();
      session.get("id" , product.getProduct);
      
      
      session.invalid();
   
   }
   */
   
   
   // WebClient 통신 메인 -> 쇼핑 (요청)
   @PostMapping("/productManagement/mainToShop")
   public ResponseEntity<MainToShopDTO> mainToShop(@RequestBody MainToShopDTO mainToShopDTO){
      System.out.println(mainToShopDTO);
      return productManagementService.mainToShop(mainToShopDTO);
   }
   
   
   // WebClient 통신 쇼핑 -> 메인 (응답)  
   @PostMapping("/productManagement/shopToMain")
   public ResponseEntity<ShopToMainResponseDTO> shopToMain(@RequestBody ShopToMainResponseDTO shopToMainResponseDTO){
      System.out.println("---------------------------------------------------------");
      System.out.println(shopToMainResponseDTO);
      // 배송.create();
      DeliveryCreateRequestDTO deliveryCreateRequestDTO = new DeliveryCreateRequestDTO();
      deliveryCreateRequestDTO.setUserName(shopToMainResponseDTO.getUserName());
      deliveryCreateRequestDTO.setHp1(shopToMainResponseDTO.getHp1());
      deliveryCreateRequestDTO.setHp2(shopToMainResponseDTO.getHp2());
      deliveryCreateRequestDTO.setHp3(shopToMainResponseDTO.getHp3());
      deliveryCreateRequestDTO.setAddress(shopToMainResponseDTO.getAddress());
      deliveryCreateRequestDTO.setZipcode(shopToMainResponseDTO.getZipcode());
      deliveryCreateRequestDTO.setProductName(shopToMainResponseDTO.getProductName());
      deliveryCreateRequestDTO.setStockCount(shopToMainResponseDTO.getOrderCount());
      deliveryCreateRequestDTO.setProductCode(shopToMainResponseDTO.getProductCode());
      System.out.println(deliveryCreateRequestDTO);
      deliveryService.createDelivery(deliveryCreateRequestDTO);
      
      System.out.println("---------------------------------------------------------");
      
      // 재고 관리 안전재고와 현재 재고 비교
      productManagementService.compareStockAndSafetyStock(shopToMainResponseDTO.getProductCode());
      
      
      return ResponseEntity.status(HttpStatus.OK).body(shopToMainResponseDTO);
   }

}