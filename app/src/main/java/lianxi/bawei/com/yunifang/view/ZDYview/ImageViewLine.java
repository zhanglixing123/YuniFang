package lianxi.bawei.com.yunifang.view.ZDYview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by mrzhang on 2016/12/5.
 * 张立兴
 */
public class ImageViewLine  extends ImageView{

    private Paint paint;

    public ImageViewLine(Context context) {
        super(context);
    }

    public ImageViewLine(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawLine(0,100,200,200,paint);
    }
}
