package demo;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        List<FEInvoiceBillholder> billList = new ArrayList<>();
        FEInvoiceBillholder feInvoiceBillholder1 = new FEInvoiceBillholder();
        feInvoiceBillholder1.setTotalAmount("200");
        feInvoiceBillholder1.setSalesTaxno("123");
        feInvoiceBillholder1.setInvoiceType("10111");
        FEInvoiceBillholder feInvoiceBillholder2 = new FEInvoiceBillholder();
        feInvoiceBillholder2.setTotalAmount("200");
        feInvoiceBillholder2.setSalesTaxno("123");
        feInvoiceBillholder2.setInvoiceType("10112");
        FEInvoiceBillholder feInvoiceBillholder3 = new FEInvoiceBillholder();
        feInvoiceBillholder3.setTotalAmount("200");
        feInvoiceBillholder3.setSalesTaxno("123");
        feInvoiceBillholder3.setInvoiceType("10112");
        billList.add(feInvoiceBillholder1);
        billList.add(feInvoiceBillholder2);
        billList.add(feInvoiceBillholder3);

        if(billList != null && billList.size() > 0) {
            Map<String, Optional<FEInvoiceBillholder>> salTaxNoMap = billList.stream()
                    .filter(x -> ("10101".equals(x.getInvoiceType()) || "10102".equals(x.getInvoiceType())))
                    .collect(Collectors.groupingBy(FEInvoiceBillholder::getSalesTaxno, Collectors.reducing((x, y) ->
                            {
                                FEInvoiceBillholder s = new FEInvoiceBillholder();
                                s.setInvoiceType("10101");
                                s.setTotalAmount(new BigDecimal(x.getTotalAmount()).add(new BigDecimal(y.getTotalAmount())).toString());
                                return s;
                            }
                    )));
            System.out.println(salTaxNoMap);
            if(salTaxNoMap.size() > 0) {
                for (Map.Entry<String, Optional<FEInvoiceBillholder>> map : salTaxNoMap.entrySet()) {
                    FEInvoiceBillholder billHolder = map.getValue().orElseGet(() -> new FEInvoiceBillholder());
                    String totalAmount = billHolder.getTotalAmount();
                    String invoiceType = billHolder.getInvoiceType();
                    //发票金额大于500并且发票类型为增值税普票或增值税电子发票
                    if(new BigDecimal(totalAmount).compareTo(new BigDecimal("500")) > 0 && "10101".equals(invoiceType)) {
                        System.out.println("sdsdsdsdsds");
                    }
                }
            }
        }


    }

}

@FunctionalInterface
interface Test{

    void test1();

    default void test2(){
        System.out.println("123321");
    }

    boolean equals(Object obj);
}
