package com.codegladiator.order.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.codegladiator.order.entity.ProductLineItem;
import com.codegladiator.order.repository.ProductLineItemRepository;
import com.codegladiator.order.service.contract.ProductLineItemService;

@Service
public class ProductLineItemServiceImpl implements ProductLineItemService {

	@Autowired
	public ProductLineItemRepository pliRepository;

	public List<ProductLineItem> getPLIsToExport() {
		List<ProductLineItem> pliList = pliRepository.findByStatus(10);
		return pliList;
	}

	public boolean writeToCsv(List<ProductLineItem> pliList, HttpServletResponse response) throws IOException {
		String filename = "plisToExport.csv";
		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
		CSVPrinter csvPrinter = null;
		 
		try {
			csvPrinter = new CSVPrinter(response.getWriter(),CSVFormat.DEFAULT.withHeader("productName", "productSku", "orderNo", "domainName", "Customer"));
			 for (ProductLineItem pli : pliList) {
			        csvPrinter.printRecord(Arrays.asList(pli.getProductName(), pli.getProductSKU(), pli.getOrder().getDocumentNo(), pli.getDomainName(), pli.getOrder().getProfile().getFirstname()+ " " + pli.getOrder().getProfile().getLastname()));
			      }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (csvPrinter != null)
				csvPrinter.close();
		}
		return true;
	}
}
