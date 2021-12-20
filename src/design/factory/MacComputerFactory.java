package design.factory;

import design.factory.cpu.Cpu;
import design.factory.cpu.MacCpu;
import design.factory.ram.MacRam;
import design.factory.ram.Ram;

/**
 * @author Xuan
 * Date: 2021/11/23
 * Time: 19:07
 */
public class MacComputerFactory implements ComputerFactory{

    @Override
    public Cpu CreateCpu() {
        return new MacCpu();
    }

    @Override
    public Ram CreateRam() {
        return new MacRam();
    }

}
