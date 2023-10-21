package ClientPackage;

import java.io.Serializable;

public class Calculatrice implements Serializable {

   private int ent1;
   private String oper;
   private int ent2;

   private int res;

   public Calculatrice(int ent1,String oper,int ent2)
   {
       this.ent1=ent1;
       this.oper=oper;
       this.ent2=ent2;
   }

   public int getEnt1()
   {
       return this.ent1;
   }

   public int getEnt2()
   {
       return this.ent2;
   }

   public String getOper()
   {
       return this.oper;
   }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
