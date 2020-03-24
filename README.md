# Decimal Degree <-> DMS Converter

도°분'초.초"를 십진도로, 십진도를 도°분'초.초" 좌표계로 바꾸는 프로젝트입니다.

## 사용법

### 도분초 -> 십진도

```Java
DMSConverter dmsConverter = new DMSConverter();
double degrees = dmsConverter.toDecimalDegrees("373356.0");
```

### 십진도 -> 도분초

```Java
DMSConverter dmsConverter = new DMSConverter();
double dms = dmsConverter.toDMS("37.565558");
```

## 주의

구글 지도에서 확인해보면 십진도 <-> 도분초 간 오차가 있습니다.

실제로 온라인 컨버터 등에서 변환해보면 오차를 확인할 수 있습니다.
