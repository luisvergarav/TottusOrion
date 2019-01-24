package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
