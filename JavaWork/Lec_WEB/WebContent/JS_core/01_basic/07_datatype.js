// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// runtime 에 개발자가 모르는 어떤 타입의 값이
// 들어올수 있다  주의!

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)
//   ..

// ---------------------------------------------------------
//  boolean 타입
// true / false
{
    const isTrue = true;
    const ifFalse = false;

    console.log(`isTrue = ${isTrue}`, typeof isTrue)
    console.log(`ifFalse = ${ifFalse}`, typeof ifFalse)

    if(isTrue) {
        console.log(isTrue, '참입니다.');
    } else {
        console.log(isTrue, '거짓입니다.');
    }

    // 객체로 생성 가능!
    // 가능은 하지만 비추..!!
    const a = new Boolean(false);   // false 값을 갖는 Boolean 객체
    console.log('a = ', a, typeof a);

    if(a) { // <- new 를 사용하여 생성하면 조건식에서 '참'으로 판정된다..!!
        console.log(a, '참입니다.');
    } else {
        console.log(a, '거짓입니다.');
    }

    // new 를 사용하지 않고 boolean 만들기
    const b = Boolean(false);   // Boolean() 함수
    console.log('b =', b, typeof b);
    if(b) { 
        console.log(b, '참입니다.');
    } else {
        console.log(b, '거짓입니다.');
    }

}

// ---------------------------------------------------------
// null
// 값이 없는 object
console.log('\n<null>');
{
    const a = null;
    console.log('a =', a, typeof a);   // null 은 object 타입
}

// ---------------------------------------------------------
// undefined
// 아무 값도 대입 안된 상태
{
    let b;  // 아무 값도 대입 안된 상태, undifined
    console.log('b =', b, typeof b);

    let a = 10;
    a = undefined;  // 다시 undefined 로 대입 가능
    console.log('a =', a, typeof a);

    a = null; b = undefined;
    if(a == b) {    // == 값이 같은지만 비교
        console.log('== 같습니다');
    } else {
        console.log('== 다릅니다');
    }

    if(a === b) {   // === 값 뿐만 아니라 type 까지 비교
        console.log('=== 같습니다');
    } else {
        console.log('=== 다릅니다');
    }

    // == 값만 비교, === 타입까지 비교
    // 가급적 JS 프로그래밍에 작성시 == 보단 === 추천
    // != 보단 !== 추천
 
 }

// ---------------------------------------------------------
// number
console.log('\n<number>')
{
    // 실수이든 정수이든 모두 number 타입
    const a = 37;
    console.log('a =', a, typeof a);
    const b = 3.14;
    console.log('b =', b, typeof b);

    const c = NaN;   // NaN(Not a Number)
    console.log('c =', c, typeof c);

    let d = Number(123);
    console.log('d =', d, typeof d);  // number
    
    d = Number('123');  // number 로 형변환 됨!
    console.log('d =', d, typeof d);  // number

    d = Number('Mark');  
    console.log('d =', d, typeof d);  // NaN

    d = parseInt('123');  // 이 또한 number 로 형변환
    console.log('d =', d, typeof d); // number

    d = parseInt('Alice');
    console.log('d =', d, typeof d); // NaN

    // 자바는 exception으로 프로그램이 죽는데 
    // 자바 스크립트는 프로그램이 죽지 않고 NaN(Not a Number)이 출력됨

    d = parseFloat('3.14');  // number 로 형변환
    d *= 2;
    console.log('d = ', d, typeof d);

    d = parseInt('3.14');   // '3.14' -> 3 으로 형변환
    console.log('d =', d, typeof d);
    
    d = parseFloat('300');
    console.log('d =', d, typeof d); // 300    

    num1 = 100; num2 = '100';
    if(num1 == num2) {  // == 값만 비교
        console.log('${num1} == ${num2} 같다');
    } else {
        console.log('${num1} == ${num2} 다르다');
    }

    num1 = 100; num2 = '100';
    if(num1 === num2) {  // === 값과 타입을 비교
        console.log('${num1} === ${num2} 같다');
    } else {
        console.log('${num1} === ${num2} 다르다');
    }

}

// ---------------------------------------------------------
// string(문자열)
// ' ~ ', " ~ " 둘 다 가능..!!
console.log('\n<string>')
{
    let a = 'Mark'
    console.log('a =', a, typeof a)

    a = "Mark"  // 쌍따옴표
    console.log('a =', a, typeof a)

    // She's gone
    // 이건 무조건 쌍따옴표
    a = "She's gone";
    console.log('a =', a, typeof a)

    // He says "Hello"
    // 이건 무조건 홑따옴표
    a = 'He says "Hello"';
    console.log('a =', a, typeof a)

    // He says "I'm fine"
    // 이런 경우는 escape 문자를 사용하면 됨
    a = "He says \"I'm fine\""
    console.log('a =', a, typeof a)

    // + 문자열 연산
    a = "Mark"
    let b = a + " Hamill";
    console.log('b =', b, typeof b)

    // 파이썬에서는 문자열 곱하기가 되나
    // 자바스크립트는 NaN(Not a Number)로 출력
    // 문자열 곱하기란? MarkMark 로 원하는 만큼 문자열이 출력됨
    console.log(a * 2)

    // 문자열 비교 연산 가능!
    // 코드순 비교..!!
    console.log("a" > "b")
    console.log("a" < "b")
    console.log("abc" < "abd")
    console.log("AAaa" > "AaAa")    // false, 대문자 < 소문자

}

//-------------------------------------------------
// symbol
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용
console.log('\n<symbol>')
{
    // 에러 : TypeError: Symbol is not a constructor
    //const a = new Symbol();
    const a = Symbol();         // new 사용하면 안됨
    const b = Symbol(37);       // Symbol(매개변수)
    const c = Symbol('Mark');
    const d = Symbol('Mark');   // c, d 는 같은 것이 아니다
                                // '고유'한 Sysbol 객체로 만들어 진다

    console.log('a =', a, typeof a);
    console.log('b =', b, typeof b);
    console.log('c =', c, typeof c);
    console.log('d =', d, typeof d);

    console.log(c == d)
    console.log(c === d)

    // 일반 문자열
    e = 'Mark', f = 'Mark'
    console.log(e == f)
    console.log(e === f)
}


console.log("\n프로그램종료\n")