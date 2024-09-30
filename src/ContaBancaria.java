public class ContaBancaria {
    // Atributos
    private int numConta;
    private String tipo; // "CC" para conta corrente, "CP" para conta poupança
    private String dono;
    private double saldo;
    private boolean status; // true = ativa, false = inativa

    // Construtor
    public ContaBancaria() {
        this.saldo = 0.0;
        this.status = false;
    }

    // Métodos getters e setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Método para abrir conta
    public void abrirConta(String tipo) {
        this.setTipo(tipo);
        this.setStatus(true);
        if (tipo.equals("CC")) {
            this.setSaldo(50.0); // Conta corrente começa com R$50
        } else if (tipo.equals("CP")) {
            this.setSaldo(150.0); // Conta poupança começa com R$150
        }
        System.out.println("Conta aberta com sucesso!");
    }

    // Método para fechar conta
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta não pode ser fechada porque ainda tem saldo.");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada porque tem débito.");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (this.isStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito de R$" + valor + " realizado na conta de " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada.");
        }
    }

    // Método para sacar dinheiro
    public void sacar(double valor) {
        if (this.isStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque de R$" + valor + " realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada.");
        }
    }
}