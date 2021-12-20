package design.factory;

import design.factory.cpu.Cpu;
import design.factory.cpu.PcCpu;
import design.factory.ram.PcRam;
import design.factory.ram.Ram;

/**
 * @author Xuan
 * Date: 2021/11/23
 * Time: 19:36
 */
public class PcComputerFactory implements ComputerFactory{
    @Override
    public Cpu CreateCpu() {
        return new PcCpu();
    }

    @Override
    public Ram CreateRam() {
        return new PcRam();
    }
}
