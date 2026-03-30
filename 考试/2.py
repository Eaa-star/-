n=list(map(int,input().split()))
m=0
n1=[]
for _ in range(1,n[1]+1):
    n1.append(_)
n2=[[3,1]]
for i in range(len(n1)):
    n2.append(n1[i:i+1])
    print(n2)
for k in (n2):
     if len(k)==1:
        m+=1
        for h in range(len(k)):
            if h%2==0 and k[h]>k[h-1]  and h%2!=0 and k[h]<k[h-1]:
               m+=1     
for j in range(1,n[1]+1):
    n1.append(j)
print(m%10000)
