# Spring-core-project
## 스프링 핵심 원리 - 기본편
### [DIP에 적합하게 할인정책 적용하기]
> 예시 코드에서는 클라이언트(OrderServiceImple)가 상위모듈인 인터페이스(DiscountPolicy)와 하위모듈인 객체(FixDiscountPolicy)를 모두 의존하고 있다   
> -> OrderService에서 FixDiscountPolicy를 직접 생성해서 사용했기 때문에...   
<br>   

> 이 상황에서는 OCP 또한 위반한다 
> > (클라이언트가 상/하위 모듈을 동시에 의존하면 할인정책을 변화(FixDiscountPolicy > RateDiscountPolicy)하는 순간 클라이언트 코드를 수정해야 하므로...
> > 따라서, 인터페이스에만 의존하도록 설계를 변경
