package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.domain.ports;

public interface CommandBus<Command> {

    public boolean execute(Command command) throws Exception;
}