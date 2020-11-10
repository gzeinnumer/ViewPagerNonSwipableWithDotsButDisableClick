# ViewPagerNonSwipableWithDotsButDisableClick
 view pager dengan dots, tapi dots tidak bsa di tekan


- Do this first [ViewPagerSimpleDots](https://github.com/gzeinnumer/ViewPagerSimpleDots)

- `MainActivity.java`
```java
public class MainActivity extends AppCompatActivity {

    ...
    
    public static TabLayout dotsTabStatic;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsTab = findViewById(R.id.dots_tab);
        dotsTabStatic = dotsTab;

        ...
        
        LinearLayout tabStrip = ((LinearLayout) dotsTab.getChildAt(0));
        for (int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }
    }
}
```


---

```
Copyright 2020 M. Fadli Zein
```
