import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NotebookMain {
    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook(36000, 8));
        notebooks.add(new Notebook(60678, 16));
        notebooks.add(new Notebook(29000, 8));
        notebooks.add(new Notebook(40000, 32));

        // сортировка по цене
        Comparator<Notebook> PriceComparator = new Price();
        Collections.sort(notebooks, PriceComparator);
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

        // Сортировка по оперативной памяти
        Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam));
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

        // Сортировка по памяти а потом по цене
        Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam)
                .thenComparingDouble(Notebook::getPrice));
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

    }

    public static class Notebook {
        private double price;
        private int ram;

        public Notebook(double price, int ram) {
            this.price = price;
            this.ram = ram;
        }

        public double getPrice() {
            return price;
        }

        public int getRam() {
            return ram;
        }

        public String printNotebook() {
            System.out.println("price: " + price + "; RAM: " + ram + ";");
            return null;
        }
    }

    // Класс сортировки по цене

    public static class Price implements Comparator<Notebook> {

        @Override
        public int compare(Notebook o1, Notebook o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    }

}