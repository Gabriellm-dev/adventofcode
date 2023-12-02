import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        problem1();
    }

    public static void problem1() {
        String caminhoArquivo = "C:\\Workspace\\adventofcode\\2023\\day1\\day1\\input.txt";

        long somaTotal = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Concatena o primeiro e último número de cada linha
                int resultadoLinha = concatenarPrimeiroUltimoNumero(linha);

                // Adiciona à soma total
                somaTotal += resultadoLinha;

                // Exibe o resultado para a linha atual
                System.out.println("Linha: " + linha + ", Resultado: " + resultadoLinha);
            }

            // Exibe a soma total ao final
            System.out.println("Soma Total: " + somaTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int concatenarPrimeiroUltimoNumero(String linha) {
        Matcher matcher = Pattern.compile("\\d").matcher(linha);
        StringBuilder numerosConcatenados = new StringBuilder();

        // Encontra todos os dígitos na linha
        while (matcher.find()) {
            numerosConcatenados.append(matcher.group());
        }

        // Verifica se há pelo menos um dígito
        if (numerosConcatenados.length() > 0) {
            // Pega o primeiro e o último dígito
            char primeiroDigito = numerosConcatenados.charAt(0);
            char ultimoDigito = numerosConcatenados.charAt(numerosConcatenados.length() - 1);

            // Concatena e converte para inteiro
            String resultadoStr = String.valueOf(primeiroDigito) + ultimoDigito;

            return Integer.parseInt(resultadoStr);
        } else {
            return 0; // Se não houver dígitos, retorna 0
        }
    }


    private static int encontrarPrimeiroNumero(String linha) {
        Matcher matcher = Pattern.compile("\\d+").matcher(linha);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return 0; // Se não encontrar nenhum número, retorna 0
        }
    }

    private static int encontrarUltimoNumero(String linha) {
        Matcher matcher = Pattern.compile("\\d+").matcher(linha);
        int ultimoNumero = 0;

        // Encontra o último número repetidamente
        while (matcher.find()) {
            ultimoNumero = Integer.parseInt(matcher.group());
        }

        return ultimoNumero;
    }
}



