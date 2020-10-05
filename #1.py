numberList = [10, 15, 3, 7]
Sum = 17
hashAarry = [None]*Sum
for i in range(0,len(numberList)):
    val = Sum-numberList[i]
    if(hashAarry[val]!=1):
        hashAarry[numberList[i]] = 1
    elif(hashAarry[val]==1):
        print ("the numbers are :=> "+ str(val) +" and  " + str(numberList[i]))
    


