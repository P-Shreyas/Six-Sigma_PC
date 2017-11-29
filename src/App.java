import java.io.*;
public class App {
    Store[] str=new Store[16];
    int strCtr=0;
    BufferedReader br=null;
    String GOOD="Good";
    String BAD="Bad";
    public void readData()
    {
        try {
            br = new BufferedReader(new FileReader("/home/shreyas/IdeaProjects/PairedComp/out/production/PairedComp/b.txt"));
            String data;
            while ((data=br.readLine()) != null)
            {
                String segements[]=data.split("\t");
                str[strCtr++]=new Store(segements[0].substring(0,segements[0].indexOf("d")+1),Double.parseDouble(segements[1]));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void sortData()
    {
        for (int i=0;i<strCtr;i++)
        {
            for(int j=i;j<strCtr;j++)
            {
                if (str[i].getValue() > str[j].getValue())
                {
                    Store temp=str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
            }
        }
    }

    public double getUpperCount()
    {
        double uc=1;
        int i=0;
        double val=0;
        while(str[i].getLabel().equals(str[i+1].getLabel()))
        {
            val=str[i].getValue();
            i++;
            uc++;
            System.out.println(str[i].getLabel()+" "+str[i+1].getLabel());
        }
        while (str[i].getValue() == val)
        {
            i--;
            uc--;
        }



        return uc;

    }


    public boolean sameTopAndBottomLabel()
    {
        boolean result=false;
        if(str[0].getLabel().equals(str[strCtr-1].getLabel()))
            result=true;
        else {
            int um=0;
            int bm=0;
            int i=0;
            while (str[i].getValue() == str[i+1].getValue())
            {
                i++;
                if(!str[i].getLabel().equals(str[i+1].getLabel()))
                {
                    um++;
                }

            }

            i=strCtr-1;
            while (str[i].getValue() == str[i-1].getValue())
            {
                i--;
                if(!str[i].getLabel().equals(str[i-1].getLabel()))
                {
                    bm++;
                }
            }
            System.out.println(um+" "+bm);

            if(bm > 0 || um > 0)
                result=true;
        }


        return result;
    }

    public void showData()
    {
        for(int i=0;i<strCtr;i++)
            System.out.println(str[i].getLabel()+"  "+str[i].getValue());
    }

    public static void main(String[] args) {
        App app=new App();
        app.readData();
        app.sortData();
        app.showData();
        double score=0;
        if(app.sameTopAndBottomLabel())
        {
            score=0;
        }
        else
        {
            double uc=app.getUpperCount();
            score=uc;
        }
        System.out.println("Final score:"+score);
    }
}

