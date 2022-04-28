package com.qx.design.factory;


import com.qx.design.factory.cpu.Cpu;
import com.qx.design.factory.ram.Ram;

/**
 * @author Xuan
 * Date: 2021/11/23
 * Time: 19:37
 */
public class FactoryTest {
    public static void main(String[] args) {
        ComputerFactory macComputerFactory = new MacComputerFactory();
        Cpu cpu = macComputerFactory.CreateCpu();
        Ram ram = macComputerFactory.CreateRam();
        System.out.println(cpu.getName());
        System.out.println(ram.getName());
    }
}
