package ie.dcu.buckley7mail.john.jbassign3;


import java.util.ArrayList;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

/**
 * @author John Buckley < john.buckley7@mail.dcu.ie>
 * @version 1.0
 * @since  2015-12-19
 */
public class PhotoGallery extends AppCompatActivity {
    /**
     *The oncreate method calls when the app is run.
     * It will create the view and start the assignment activity
     * @see android.app.Activity#onCreate(android.os.Bundle)
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        /**
         * GridView is captured from the activity_photo_gallery xml layout by the findViewById
         * GridView is a view that shows items in two-dimensional scrolling grid.
         * @see android.widget.GridView
         * findViewById finds the view by id gridview, the id attribute from the xml
         * @see android.app.Activity#findViewById(android.os.Bundle)
         */
        GridView gridview = (GridView) findViewById(R.id.gridview);
        /**
         *  setAdapter sets the data behing the list view
         *  @see android.widget.ListView#setAdapter(ListAdapter)
         *  setAdapter sets a custom adapter called ImageAdapter. This is the soucre for all items to be displayed in the grid
         *  ImageAdapter Class will be created.
         */
        gridview.setAdapter(new ImageAdapter(this));
        /**
         *setOnItemClickListener will register a callback that will be invoked whenever an item in the ImageAdapter is clicked
         *@see  android.widget.AdapterView<T extends android.widget.Adapter>
         */
        gridview.setOnItemClickListener(new OnItemClickListener() {
            /**
             * interface definition for a callback to be invoked when an item in the AdapterView has been clicked.
             * start a new activity images when the item has be clicked
             * @param parent The AdapterView where teh click happened
             * @param v The view within the AdapterView that was clicked (provided by the adapter)
             * @param position The position of the view in the adapter
             * @param id The row id of the item clicked
             * @see android.widget.AdapterView.OnItemClickListener
             */
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
               Intent images = new Intent(Intent.ACTION_VIEW);
                startActivity(images);
            }
        });

    }

    /**
     * This ImageAdapter class will implement the functionality of the adpater which is used to fill the view
     */
    public class ImageAdapter extends BaseAdapter
    {
        private Context mContext;
        /**
         *
         * @param c
         */
        public ImageAdapter(Context c)
        {
            mContext = c;
        }
        /**
         *
         * @return
         */
        public int getCount()
        {
            return mThumbIds.length;
        }
        /**
         *
         * @param position
         * @return
         */
        public Object getItem(int position)
        {
            return null;
        }
        /**
         *
         * @param position
         * @return
         */
        public long getItemId(int position)
        {
            return 0;
        }
        /**
         *create a new ImageView for each item referenced by the Adapter
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null)
            {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else
            {
                imageView = (ImageView) convertView;
            }
            /**
             *
             */
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images

        private Integer[] mThumbIds =
                {
                    R.drawable.sample_2, R.drawable.sample_3,
                    R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7,
                    R.drawable.sample_0, R.drawable.sample_1,
                    R.drawable.sample_2, R.drawable.sample_3,
                    R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7,
                    R.drawable.sample_0, R.drawable.sample_1,
                    R.drawable.sample_2, R.drawable.sample_3,
                    R.drawable.sample_4, R.drawable.sample_5,
                    R.drawable.sample_6, R.drawable.sample_7
        };
    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_gallery, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
