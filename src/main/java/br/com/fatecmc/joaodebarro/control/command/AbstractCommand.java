package br.com.fatecmc.joaodebarro.control.command;

import br.com.fatecmc.joaodebarro.control.Facade;
import br.com.fatecmc.joaodebarro.control.IFacade;

public abstract class AbstractCommand implements ICommand {
    protected IFacade facade = new Facade();
}
