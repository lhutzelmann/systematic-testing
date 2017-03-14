package org.hutzelmann.javakurs;

import org.hutzelmann.javakurs.sut.Application;

public class Cli
{
    public static void main( String[] args )
    {
        Application app = new Application();
        app.run();
    }
}
