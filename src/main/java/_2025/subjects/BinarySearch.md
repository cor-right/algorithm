
## Binary Search

一种针对有序区间的 O(longN) 的搜索方式

### 基本原则
1. 每次都要缩减搜索区域
2. 每次缩减都不能排除潜在答案

### 三大模板


#### 1. 找准确值
```aidl
while (left <= right) {
    // ...
    left  = mid + 1;
    right = mid - 1;
}
```

#### 2. 找一个模糊值（比4大的最小数）
```aidl
while (left < right) {
    // ...
    left  = mid;
    right = mid - 1;

    // ...
    left  = mid + 1;
    right = mid;
}
```

#### 3. 万用型
```aidl
while (left < right - 1) {
    left  = mid;
    right = mid;
}
```