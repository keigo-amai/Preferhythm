[WIP]Preferhythm
====

[![Download](https://api.bintray.com/packages/kazakago/maven/preferhythm/images/download.svg)](https://bintray.com/kazakago/maven/preferhythm/_latestVersion)
[![Bitrise](https://www.bitrise.io/app/436ed4113cb15072.svg?token=5I58EK088C0wp3UWmf75qA&branch=master)]()
[![license](https://img.shields.io/github/license/kazakago/preferhythm.svg)](LICENSE.md)

[TODO: 概要]

## Requirement

- Android 4.0.3 (API 15) or later

## Install

Add the following gradle dependency exchanging x.x.x for the latest release.

### Java

```groovy
dependencies {
    compile 'com.kazakago.preferhythm:preferhythm:x.x.x'
    annotationProcessor 'com.kazakago.preferhythm:preferhythm-processor:x.x.x'
}
```

### Kotlin

```groovy
apply plugin: 'kotlin-kapt'

dependencies {
    compile 'com.kazakago.preferhythm:preferhythm:x.x.x'
    kapt 'com.kazakago.preferhythm:preferhythm-processor:x.x.x'
}
```

## Supported Type

- Primitive Type
  - int
  - long
  - float
  - boolean
- Object Type
  - Integer 
  - Long
  - Float
  - Boolean
  - String
  - Set\<String\>

This is the same as Android's SharedPreferences specification. [More details](https://developer.android.com/training/basics/data-storage/shared-preferences.html).


## Usage

[TODO: モデルクラス構築方法]

```java
@PrefClass // `@PrefClass` is nessesary for your preferences model class.
class MyPreferences {

    @PrefField // `@PrefField` is nessesary for your preference value.
    int intValue = 3; // default value is `3`.

    @PrefField
    boolean booleanValue; // default value is `false`. (primitive default value)

    @PrefField
    String stringValue; // default value is `null`.

    @NonNull
    @PrefField
    String nonNullStringValue = "foo"; // NonNull annotation with default value.

}
```

[TODO: MainActivityでの使い方]

```java
public class MainActivity extends Activity {

    // `MyPreferencesManager` class is auto generated.
    private MyPreferencesManager myPreferencesManager = new MyPreferencesManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        System.out.print(myPreferencesManager.getIntValue()); // 3 (default value)

        myPreferencesManager.putIntValue(100); // set 100
        myPreferencesManager.commit(); // commit change.

        System.out.print(myPreferencesManager.getIntValue()); // 100
        
        myPreferencesManager.clear(); // clear value.
        myPreferencesManager.commit(); // commit change.

        System.out.print(myPreferencesManager.getIntValue()); // 3 (default value)
    }

}
```

Refer to the sample module ([Java](https://github.com/KazaKago/Preferhythm/tree/master/samplejava) & [Kotlin](https://github.com/KazaKago/Preferhythm/tree/master/samplekotlin)) for details.

## Important

[TODO: 変数の名前でSharedPreferencesに保存されるので変数名を変更するとSharedPreferences上別の値として保存されるので注意]

## Advanced

if you want to change Preferences name, extend `[PREFERENCES_MODEL_NAME] + Manager` class and override getPreferencesName() method.

```java
public class CustomMyPreferencesManager extends MyPreferencesManager {

    public CustomMyPreferencesManager(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected String getSharedPreferencesName() {
        return "CUSTOM_SHARED_PREFERENCES_NAME";
    }

}
```

## Kotlin Support

[TODO: Kotlinサポート内容]

## License
MIT License

Copyright (c) 2017 KazaKago

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
