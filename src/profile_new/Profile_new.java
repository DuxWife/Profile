package profile_new;
import java.io.*;
public class Profile_new {
    public static void main(String[] args) throws IOException{
     int n,i,j,p,max=0,m,H,L,h,l;
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("введите количество высот:");
        n=Integer.parseInt(br.readLine ());
        int [] a= new int[n];
        int [] k= new int[n];
        for (i=0;i<n;i++){
         System.out.print("введите "+(i+1)+" высоту:");
         a[i]=Integer.parseInt(br.readLine ());
        }
        for(i=0;i<n;i++) {
            if (i==0|i==n-1)k[i]=1;
            else k[i]=2;
        }
        for (i=0;i<n;i++) {
            if (i>=2){
                for (j=0;j<i-1;j++){
                    m=0;
                    H=Math.abs(a[i]-a[j]);
                    for (p=j+1;p<i;p++){
                        if (a[i]>=a[j]){
                            h=a[p]-a[j];
                            L=i-j;
                            l=p-j;
                            if (h<=(double)(H*l)/L) m++;
                        }
                        else {
                            h=a[p]-a[i];
                            L=i-j;
                            l=i-p;
                            if (h<=(double)(H*l)/L) m++;
                        }
                    }
                    if (m==i-j-1) k[i]++;
                }
            }
            if (i<n-2){
                for (j=i+2;j<n;j++){
                    m=0;
                    H=Math.abs(a[i]-a[j]);
                    for (p=i+1;p<j;p++){
                        if (a[i]>=a[j]){
                            h=a[p]-a[i];
                            L=j-i;
                            l=j-p;
                            if (h<=(double)(H*l)/L) m++;
                        }
                        else{
                            h=a[p]-a[i];
                            L=j-i;
                            l=p-i;
                            if (h<=(double)(H*l)/L) m++;
                        }
                    }
                    if (m==j-i-1) k[i]++;
                }
            }
        }
        for(i=0;i<n;i++) if (max<k[i]) max=k[i];      
        for(i=0;i<n;i++) if (k[i]==max) System.out.print((i+1)+" ");
    }    
}