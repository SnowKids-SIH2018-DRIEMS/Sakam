package xyz.sumeshmajhi.www.sakam.Assam;

/**
 * Created by saGen on 30-03-2018.
 */

import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;

import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Dalobari;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Harihar;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Mukhigaons;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_mongolian;
import xyz.sumeshmajhi.www.sakam.Ashram_Assam.Ashram_Mukhigaon;
import xyz.sumeshmajhi.www.sakam.R;

/**
 * Created by saGen on 12-03-2018.
 */

public class Assam_ashram  extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false );
        ContentAdapter adapter = new ContentAdapter( recyclerView.getContext() );
        recyclerView.setAdapter( adapter );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super( inflater.inflate( R.layout.assam_ashram,parent, false ) );
            picture = (ImageView) itemView.findViewById( R.id.card_image );
            name = (TextView) itemView.findViewById( R.id.card_title );
            description = (TextView) itemView.findViewById( R.id.card_text );
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    final Intent intent;
                    switch (getAdapterPosition()){
                        case 0:
                            intent =  new Intent(context, Ashram_Harihar.class);
                            break;

                        case 1:
                            intent =  new Intent(context, Ashram_Dalobari.class);
                            break;

                        case 2:
                            intent =  new Intent(context, Ashram_mongolian.class);
                            break;

                        case 3:
                            intent=new Intent( context,Ashram_Mukhigaons.class );
                            break;
                        default:
                            intent=new Intent( context, Ashram_Mukhigaon.class );
                            break;
                    }
                    context.startActivity(intent);
                }
            } );
         /* // Adding Snackbar to Action Button inside card
            Button button = (Button)itemView.findViewById(R.id.action_button);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Action is pressed",
                            Snackbar.LENGTH_LONG).show();
                }
            });*/

            ImageButton favoriteImageButton =
                    (ImageButton) itemView.findViewById( R.id.favorite_button );
            favoriteImageButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make( v, "Added to Favorite",
                            Snackbar.LENGTH_LONG ).show();
                }
            } );

            ImageButton shareImageButton = (ImageButton) itemView.findViewById( R.id.share_button );
            shareImageButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make( v, "Share article",
                            Snackbar.LENGTH_LONG ).show();
                }
            } );
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 5;

        private final String[] mPlaces;
        private final String[] mPlaceDesc;
        private final Drawable[] mPlacePictures;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray( R.array.places );
            mPlaceDesc = resources.getStringArray( R.array.assam_ashram_school_name );
            TypedArray a = resources.obtainTypedArray( R.array.as_ashram_image );
            mPlacePictures = new Drawable[a.length()];
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable( i );
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder( LayoutInflater.from( parent.getContext() ), parent );
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable( mPlacePictures[position % mPlacePictures.length] );
            holder.name.setText( mPlaces[position % mPlaces.length] );
            holder.description.setText( mPlaceDesc[position % mPlaceDesc.length] );
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}