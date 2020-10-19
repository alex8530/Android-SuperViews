# Android-SuperButton

## This library make these things : 

- improve the ViewGruops And Views Like (View,FrameLayout,LinearLayout,RelativeLayout,Button)  and add the possibility of changing these attributes :
- corner form one side only or more 
- change the radius of corner
- change shadow color and shadow radius
- change stroke color and stroke radius

### The library offers the following classes
- SuperButton 
  - This class extend MaterialButton
- SuperFrameLayout 
  - This class extend FrameLayout
- SuperLinearLayout 
  - This class extend LinearLayout
- SuperRelativeLayout 
  - This class extend  RelativeLayout
- SuperView 
  - This class extend View

## Example on Button
![Image Result](https://i.ibb.co/W21YsKS/Screenshot-2020-10-16-022754.png)

## Exambple on All Views
![Image Result](https://i.ibb.co/4Pj5Jvs/Screenshot-1603129757.png)



 

## Getting started
* In ``` build.gradle ``` (  Project Level  )

Add maven of jitback

 ```
allprojects { 
     repositories { 
        maven { url 'https://jitpack.io' }
      }
 }   
```
* In ``` build.gradle ``` (  app Level  )

                      

Add library as dependency [![](https://jitpack.io/v/alex8530/Android-SuperViews.svg)](https://jitpack.io/#alex8530/Android-SuperViews)

```
   implementation 'com.github.alex8530:Android-SuperButton:Tag'
```
and be sure you have material
```
 implementation "com.google.android.material:material:1.2.1"
```
   

## How to use

* First, add  ```xml  android:clipChildren="false" ``` to the parent layout to enable shadow appears 
* your app theme should extent Theme.MaterialComponents theme, Like this :  ```xml <style name="AppTheme" parent="Theme.MaterialComponents.Light"> ``` Or you can add the theme directly to your layout parent like this:   ```xml android:theme="@style/Theme.MaterialComponents.Light" ```


## Example on Button , Note , All Other views are the same as button !
```xml
     <alex.superlibrary.SuperButton
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:padding="10dp"
        android:text="@string/button"
        android:textAlignment="center"
        android:textColor="@color/colorBlack"
        android:textStyle="bold"
        app:alex_bottomEdgeDirection="OutSide"
        app:alex_bottomEdgeRadius="@dimen/dimen_30"
        app:alex_bottomLeftCornerFamily="Round"
        app:alex_bottomLeftCornerRadius="@dimen/dimen_30"
        app:alex_bottomRightCornerFamily="Cut"
        app:alex_bottomRightCornerRadius="@dimen/dimen_30"
        app:alex_fillColor="@color/colorAccent"
        app:alex_leftEdgeDirection="Inside"
        app:alex_leftEdgeRadius="@dimen/dimen_30"
        app:alex_rightEdgeDirection="Inside"
        app:alex_rightEdgeRadius="@dimen/dimen_30"
        app:alex_shadowColor="@color/colorGreen"
        app:alex_shadowElevation="@dimen/dimen_30"
        app:alex_strokeColor="@color/colorRed"
        app:alex_strokeWidth="@dimen/dimen_5"
        app:alex_topEdgeDirection="OutSide"
        app:alex_topEdgeRadius="@dimen/dimen_30"
        app:alex_topLeftCornerFamily="Round"
        app:alex_topLeftCornerRadius="@dimen/dimen_30"
        app:alex_topRightCornerFamily="Cut"
        app:alex_topRightCornerRadius="@dimen/dimen_30" />
```
* create file dimens.xml in values and put in it this code , And be careful , thrse is no <b>dp</b> here !
```xml  
<resources>
    <dimen name="dimen_0">0</dimen>
    <dimen name="dimen_30">30</dimen>
    <dimen name="dimen_60">60</dimen>
    <dimen name="dimen_15">15</dimen>
    <dimen name="dimen_5">5</dimen>
    <dimen name="dimen_2">2</dimen>
</resources>
```
  * Enjoy!
 
  
## License

```
Copyright (c) 2020 Ali Abu Harb

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
