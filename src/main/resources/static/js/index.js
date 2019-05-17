function toThousand() {

    var num='123456789.36';

    var cents;
    var intpart;
    var position;
    var result = '';

    var num = num.toString();
    position = num.index('.');  //9

    if (position < 0) {
        cents = '00';
        intpart = num;
    }
    else{
        cents=num.slice(position+1); //36
        intpart=num.slice(0,position);//123456789
    }

    /**
     * 第一遍循环:
     *  result=,789
     *  intpart=123456
     *
     *第二遍循环:
     *  result=,456,789
     *  intpart=123
     *
     */
    while(intpart.length>3){
        result=','+intpart.slice(-3)+result;// ',789'
        intpart=intpart.slice(0,intpart.length-3);// 123456
    }
    if(intpart){
        result =intpart+result; //123,456,789
    }

    return result+'.'+cents; //123,456,789.36

}