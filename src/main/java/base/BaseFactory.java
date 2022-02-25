package base;

import util.Base;

public class BaseFactory {

    public Base getBase (String baseType) {

        if (baseType == "Chrome") {
            return new ChromeBase();
        }
        else if (baseType == "Edge") {
            return new EdgeBase();
        } else {
            return null;
        }

    }

}
