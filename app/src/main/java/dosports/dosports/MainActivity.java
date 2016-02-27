package dosports.dosports;

import android.app.Activity;

//import android.os.AsyncTask;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
/*
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.net.http.AndroidHttpClient;
*/

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        //new HttpGetTask().execute();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();

        switch (position){
            case 0:
                crear_evento c = new crear_evento();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, c).addToBackStack(null)
                        .commit();
                break;
            case 1:
                Lista_Eventos l = new Lista_Eventos();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, l).addToBackStack(null)
                        .commit();
                break;
            case 2:
                Perfil p = new Perfil();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, p).addToBackStack(null)
                        .commit();
                break;
            case 3:
                Intent i = new Intent(this,Login.class);//Volvemos al Login del sistema.
                startActivity(i);
                finish();
                break;
        }

        restoreActionBar();

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.crear_evento);
                break;
            case 2:
                mTitle = getString(R.string.lista_eventos);
                break;
            case 3:
                mTitle = getString(R.string.perfil);
                break;
            case 4:
                mTitle = getString(R.string.cerrar_sesion);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public void onBackPressed() {
        getFragmentManager().popBackStack();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }













/*
    //Definicion de la clase que utilizaremos para parsear el JSON del que obtendremos los restaurantes a almacenar en nuestra base de datos.
    private class HttpGetTask extends AsyncTask<Void, Void, List<String>> {
        //URL del JSON
        private static final String URL = "https://dl.dropboxusercontent.com/u/51365577/hello.json";

        AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

        @Override
        protected void onPreExecute() {
            Log.i("json", "Antes de ejecutar");
            super.onPreExecute();
        }

        @Override
        protected List<String> doInBackground(Void... params) {
            HttpGet request = new HttpGet(URL);
            JSONResponseHandler responseHandler = new JSONResponseHandler();//Clase definida en la parte posterior de este archivo.
            //Nos permitira parsear el JSON.
            Log.i("json", "Ejecutando");

            try {
                return mClient.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                Log.i("json", "catch1");
                e.printStackTrace();
            } catch (IOException e) {
                Log.i("json", "catch2");
                e.printStackTrace();
            }

            Log.i("json","terminando ejecución");

            return null;
        }

        @Override
        protected void onPostExecute(List<String> result) {
           // if (null != mClient)
               // mClient.close();

            //Una vez terminado de parsear el JSON, obtendremos la localizacion actual del dispositivo, y la cargaremos en la clase
            //vistaPrincipal

            Log.i("json", "Ejecución terminada");

        }

        private class JSONResponseHandler implements ResponseHandler<List<String>> {

            @Override
            public List<String> handleResponse(HttpResponse response)
                    throws ClientProtocolException, IOException {

                Log.i("json", "Antes de obtener");
                List<String> result = new ArrayList<String>();
                String JSONResponse = new BasicResponseHandler()
                        .handleResponse(response);
                try {

                    // Get top-level JSON Object - a Map
                    JSONObject responseObject = (JSONObject) new JSONTokener(
                            JSONResponse).nextValue();

                    String m = responseObject.getString("0");
                    result.add(m);

                    Log.i("json", "obtenido: " + responseObject.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return result;
            }
        }

    }*/
}
