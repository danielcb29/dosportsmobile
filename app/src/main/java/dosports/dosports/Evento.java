package dosports.dosports;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Evento extends Fragment {

    private String[] nomeventos={"Fútbol 7", "Baloncesto", "Volleyball", "Pádel", "Fútbol", "Tenis", "Baloncesto", "Béisbol", "Volleyball", "Pádel"};

    private String[] lugeventos={"Pabellón Multiusos", "Pista Los Fratres", "Pabellón Moctezuma", "Pista La Madrila", "Pista Los Fratres", "Pabellón Moctezuma", "Pista La Madrila", "Pista Los Fratres","Pabellón Moctezuma", "Pista La Madrila"};

    private String[] feceventos={"01/04/2016 - 21:30", "17/03/2016 - 18:00", "09/03/2016 - 11:30", "15/03/2016 - 17:00", "17/03/2016 - 18:00", "09/03/2016 - 11:30", "15/03/2016 - 17:00", "17/03/2016 - 18:00", "09/03/2016 - 11:30", "15/03/2016 - 17:00"};

    private String[] participantes={"Alberto Ricci Vázquez", "Gerardo Bernal Ortiz", "Cristina Extremera Romero", "Daniel Correa Barrios", "Cristian Mariscal Gil", "Enrique Gómez Ruíz"};

    private int posicion;

    public Evento() {
        // Required empty public constructor
    }

    public void setPosicion(int pos){
        posicion=pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_evento, container, false);

        TextView nombreEvento = (TextView) view.findViewById(R.id.nombreEvento);
        nombreEvento.setText(nomeventos[posicion] + " - " + lugeventos[posicion]);

        TextView fechaEvento = (TextView) view.findViewById(R.id.fechaEvento);
        fechaEvento.setText("Fecha: " + feceventos[posicion]);

        ListView listaParticipantes=(ListView)view.findViewById(R.id.Participantes);
        ListAdapter la = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,participantes);
        listaParticipantes.setAdapter(la);

        return view;
    }


}
