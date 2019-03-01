package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.CreateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.CreateProductCommandImpl;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.DecoratorCreateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.DecoratorEanUpdateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.DecoratorHierarchyUpdateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.DecoratorStateUpdateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.DecoratorUpdateProductCommandBus;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.EanUpdateProductCommandImpl;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.HierarchyUpdateProductCommandImpl;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.StateUpdateProductCommandImpl;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.application.adapters.UpdateProductCommandImpl;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports.CreateProductCommand;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.constants.RestConstants;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.APIResponse;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.EanUpdateProduct;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.Product;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.ProductHierarchyUpdate;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.StateUpdateProduct;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.http.rest.domain.UpdateProduct;
import rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.output.asb.internal.EventProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/")
@Api(value = "ORION", description = "ORION Prouct Management API")
@Slf4j
@EnableSwagger2
public class ProductController {

	@Autowired
	private EventProperties eventProperties;
	
	@Autowired
	private HttpServletRequest context;

	@Autowired
	DecoratorCreateProductCommandBus cmdBus;

	@Autowired
	DecoratorStateUpdateProductCommandBus cmdStateUpdateBus;

	@Autowired
	DecoratorUpdateProductCommandBus cmdUpdateBus;

	@Autowired
	DecoratorEanUpdateProductCommandBus cmdEanUpdateBus;


	@Autowired
	DecoratorHierarchyUpdateProductCommandBus cmdHierarchyUpdateBus;

	@RequestMapping(path = "/MREX/PRMG/v1.0/PRODUCT", method = POST)
	@ApiOperation(value = "Add Product", response = APIResponse.class)
	public ResponseEntity<APIResponse> createProduct(@RequestBody Product request) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
	
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		// E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Create Product request.", request);
		try {

			CreateProductCommandImpl cmd = new CreateProductCommandImpl(request);

			if (cmdBus.execute(cmd))
				log.info("Product Created successful ", request.getSku());
			else{
				log.info("Product not Created ", request.getSku());
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Product not Created"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Product Created Exception ", request.getSku());
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Product Created"), HttpStatus.OK);
	}

	@RequestMapping(path = "/MREX/PRMG/v1.0/PRODUCT", method = PUT)
	@ApiOperation(value = "Update a Product", response = APIResponse.class)
	public ResponseEntity<APIResponse> updateProduct(@RequestBody UpdateProduct request) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
		
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		
		//E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Update Product request.", request);
		try {

			UpdateProductCommandImpl cmd = new UpdateProductCommandImpl(request);

			if (cmdUpdateBus.execute(cmd))
				log.info("Product Updated successful ", request.getSku());
			else{
				log.info("Product not Updated ", request.getSku());
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Product not updated"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Product Updated Exception ", request.getSku());
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Product Updated"), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(path = "/MREX/PRMG/v1.0/PRODUCT/{skuId}/{state}", method = PUT)
	@ApiOperation(value = "Update a Product", response = APIResponse.class)
	public ResponseEntity<APIResponse> updateProduct(@PathVariable String skuId, @PathVariable String state) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
		
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		
		//E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Update Product State request.", skuId + " " + state);
		try {

			StateUpdateProduct stateUpdateProduct = new StateUpdateProduct();
			stateUpdateProduct.setSku(skuId);
			stateUpdateProduct.setStatus(state);
			StateUpdateProductCommandImpl cmd = new StateUpdateProductCommandImpl(stateUpdateProduct);

			if (cmdStateUpdateBus.execute(cmd))
				log.info("Product Updated successful ", skuId);
			else{
				log.info("Product not Updated ", skuId);
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Product not updated"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Product Updated Exception ", skuId);
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Product Updated"), HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(path = "/MREX/PRMG/v1.0/PRODUCT/{skuId}/ean/{ean}", method = PUT)
	@ApiOperation(value = "Update a Product Ean", response = APIResponse.class)
	public ResponseEntity<APIResponse> updateProductEan(@PathVariable String skuId, @PathVariable String ean) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
		
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		
		//E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Update Product Ean request.", skuId + " " + ean);
		try {

			EanUpdateProduct eanUpdateProduct = new EanUpdateProduct();
			eanUpdateProduct.setSku(skuId);
			eanUpdateProduct.setEan(ean);
			EanUpdateProductCommandImpl cmd = new EanUpdateProductCommandImpl(eanUpdateProduct);

			if (cmdEanUpdateBus.execute(cmd))
				log.info("Product Ean Updated successful ", skuId);
			else{
				log.info("Product Ean not Updated ", skuId);
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Product Ean not updated"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Product Ean Updated Exception ", skuId);
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Product Ean Updated"), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(path = "/MREX/PRMG/v1.0/PRODUCT/{skuId}/hierarchy", method = PUT)
	@ApiOperation(value = "Update a Product Hierarchy", response = APIResponse.class)
	public ResponseEntity<APIResponse> updateProductHierarchy(@PathVariable String skuId, @RequestBody ProductHierarchyUpdate hierarchy) {

		log.info(context.getHeader("Country") +  context.getHeader("Commerce") + context.getHeader("Channel"));
		
		eventProperties.setChannel(context.getHeader("Channel") );
		eventProperties.setCommerce(context.getHeader("Commerce") );
		eventProperties.setCountry(context.getHeader("Country") );
		eventProperties.setMimeType(context.getHeader("Content-Type") );
		eventProperties.setVersion("1.0");
		
		
		//E2EContext e2e = new E2EContext();
		// try {
		// e2e.setE2EContext(headers);
		// } catch (E2EHelperNotFoundException e) {
		// log.error("Error E2EContext setting headers");
		//
		// }
		// e2e.setServiceRef("Appointment");

		log.info("Update Product Hierarchy request.", skuId + " " + hierarchy);
		try {

			HierarchyUpdateProductCommandImpl cmd = new HierarchyUpdateProductCommandImpl(hierarchy,skuId);

			if (cmdHierarchyUpdateBus.execute(cmd))
				log.info("Product Hierarchy Updated successful ", skuId);
			else{
				log.info("Product Hierarchy not Updated ", skuId);
				return new ResponseEntity<APIResponse>(this.buildErrorRes("Product Hierarchy not updated"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			log.debug("Product Hierarchy Updated Exception ", skuId);
			return new ResponseEntity<APIResponse>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<APIResponse>(this.buildSuccessRes("Product Hierarchy Updated"), HttpStatus.OK);
	}
	/**
	 * API success response
	 *
	 * @return
	 */

	private APIResponse buildSuccessRes(String msg) {
		APIResponse res = new APIResponse();
		res.setCode(RestConstants.SUCCESS_CODE);
		res.setType(RestConstants.SUCCESS_RESPONSE);
		res.setMessage(msg);
		return res;
	}

	/**
	 * API Error response
	 *
	 * @return
	 */
	private APIResponse buildErrorRes(String error) {
		APIResponse res = new APIResponse();
		res.setCode(RestConstants.ERROR_CODE);
		res.setType(RestConstants.SYSTEM_ERROR);
		res.setMessage(error);
		return res;
	}

}