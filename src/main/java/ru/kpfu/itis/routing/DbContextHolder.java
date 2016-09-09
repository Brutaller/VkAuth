package ru.kpfu.itis.routing;

/**
 * Created by etovladislav on 07.09.16.
 */

public class DbContextHolder {

    private static final ThreadLocal<DbType> contextHolder =
            new ThreadLocal<DbType>();

    public static void setDbType(DbType dbType) {
        if(dbType == null){
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }

    public static DbType getDbType() {
        return (DbType) contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}