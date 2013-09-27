package com.portfolio.model.db.dao;

import java.util.List;

public interface GenericInterfaceDAO<T> {


    public long insert(T o) throws Exception;
    public int update(T o) throws Exception;
    public int delete(T o) throws Exception;
    public List<T> getAll() throws Exception;
    public Object get(long id) throws Exception;
    public boolean enableBDD() throws Exception;
    public boolean closeBDD() throws Exception;
    public void deleteAll() throws Exception;

}
