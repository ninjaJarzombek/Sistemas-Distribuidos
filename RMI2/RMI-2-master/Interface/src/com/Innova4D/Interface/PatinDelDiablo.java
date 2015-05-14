package com.Innova4D.Interface;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Created by Aurelio on 11/03/2015.
 */
public class PatinDelDiablo implements Serializable {


    private static final long serialVersionUID = 45L;

    private int x;
    private int y;
    private String id;

    public PatinDelDiablo(String id, int x, int y) throws RemoteException {
        super();
        this.id = id;
        this.setX(x);
        this.setY(y);
    }

    public String getId() throws RemoteException  {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
