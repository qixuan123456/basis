package design.factory;

import design.factory.cpu.Cpu;
import design.factory.ram.Ram;

/**
 * @author Xuan
 * Date: 2021/11/23
 * Time: 19:02
 */
public interface ComputerFactory {
    public Cpu CreateCpu();
    public Ram CreateRam();
}
