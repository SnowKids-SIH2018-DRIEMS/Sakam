package xyz.sumeshmajhi.www.sakam.Odisha;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.sumeshmajhi.www.sakam.Emrs_Od.Emrs_Dhangera;
import xyz.sumeshmajhi.www.sakam.Emrs_Od.Emrs_Hirli;
import xyz.sumeshmajhi.www.sakam.Emrs_Od.Emrs_Sungargarh;
import xyz.sumeshmajhi.www.sakam.Emrs_Od.Emrs_keonjhar;
import xyz.sumeshmajhi.www.sakam.Emrs_Od.Emrs_gajapati;
import xyz.sumeshmajhi.www.sakam.R;

/**
 * Created by saGen on 12-03-2018.
 */

public class Odisha_eklavya   extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate( R.layout.recycler_view, container, false );
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

        public ViewHolder(final LayoutInflater inflater, ViewGroup parent) {
            super( inflater.inflate( R.layout.odisha_ek, parent, false ) );


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
                            intent =  new Intent(context, Emrs_gajapati.class);
                            break;

                        case 1:
                            intent =  new Intent(context, Emrs_Dhangera.class);
                            break;

                        case 2:
                            intent =  new Intent(context, Emrs_Hirli.class);
                            break;

                        case 3:
                            intent=new Intent( context,Emrs_Sungargarh.class );
                            break;
                        default:
                            intent=new Intent( context, Emrs_keonjhar.class );
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
            mPlaceDesc = resources.getStringArray( R.array.odisha_emrs_school_name );
            TypedArray a = resources.obtainTypedArray( R.array.odisha_emrs_image );
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
