package design_pattern.Creational_Pattern.factory_method;

interface Connection {
    public void connect();

    public void query(String queryString);
}

class mySQL implements Connection {

    @Override
    public void connect() {
        System.out.println("Connect to mySQL database");

    }

    @Override
    public void query(String queryString) {
        System.out.println("mySQL QUERY:" + queryString);

    }

}

class Oracle implements Connection {

    @Override
    public void connect() {
        System.out.println("Connect to Oracal database");

    }

    @Override
    public void query(String queryString) {
        System.out.println("Oracal QUERY :" + queryString);

    }

}

class Factory {

    public static Connection getConnection(String dbServer) {
        if (dbServer.equals("mySQL"))
            return new mySQL();
        else if (dbServer.equals("Oracle"))
            return new Oracle();

        return null;
    }

}

public class Main {

    public static void main(String[] args) {
        Connection connection = Factory.getConnection("mySQL");

        connection.connect();
        connection.query("SELECT * FROM USERS");
    }
}
