package dao;

import model.Invoice;

public class InvoiceDao extends AbstractDaoImpl<Invoice> {
    public InvoiceDao() {
        super(Invoice.class);
    }
}
