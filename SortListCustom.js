
(function itemsSort() {
    // Write your code here
    let items = [10,5,5,5,5,2,4,6,7,2,1,1,1,1,1,9,8];
    let itemCount = {};
    for(let num of items){
        if(itemCount.hasOwnProperty(num)){
            itemCount[num]++;
        }else{
            itemCount[num]=1;
        }
    }
    items.sort((x,y)=>{
        if(itemCount[x]!=itemCount[y]){
            return itemCount[x] - itemCount[y];
        }
        return x-y;
    });
    console.log(items);
})();