package energy_net;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnergyMarket {
	
	protected Map<String, Consumer> consumers;
	protected ArrayList<EnergyRequest> energyRequests;
	protected ArrayList<EnergyOffer> energyOffers;
	protected Set<Transaction> transactions;
	protected double moneyEarned;
	protected double percentageEarned;
	
	public EnergyMarket(double profitPercentage) {
        this.consumers = new HashMap<>();
        this.energyRequests = new ArrayList<>();
        this.energyOffers = new ArrayList<>();
        this.transactions = new HashSet<>();
        this.moneyEarned = 0;
        this.percentageEarned = profitPercentage;
    }
	
	public double getMoneyEarned() {
		return moneyEarned;
	}
	
	public void addConsumerOrProsumer(Consumer consumer) {
		consumers.put(consumer.getIPAddress(), consumer);
	}
	
	public Consumer searchConsumerProsumer(String IP_address) {
		return consumers.get(IP_address);	
	}
	
	public void addEnergyRequest(EnergyRequest request) {
		energyRequests.add(request);
		trade();
	}
	
	public void addEnergyOffer(EnergyOffer offer) {
        energyOffers.add(offer);
        trade();
    }
	
	public boolean createdTransaction(EnergyRequest request, EnergyOffer offer, int tradedEnergyAmount) {
        double totalPrice = tradedEnergyAmount * offer.getPricePerKilowatt();
        Consumer consumer = searchConsumerProsumer(request.owner.getIPAddress());
        Prosumer prosumer = (Prosumer) searchConsumerProsumer(offer.owner.getIPAddress());

        if (consumer.getBalance() < totalPrice) {
            return false;
        }

        consumer.deductAmount(totalPrice);
        
        double profit = totalPrice * percentageEarned;
        moneyEarned += profit;
        double left = totalPrice - profit;
        
        prosumer.addAmount(left);

        Transaction transaction = new Transaction(request, offer, tradedEnergyAmount, totalPrice);
        transactions.add(transaction);

        return true;
    }

    public EnergyOffer findOffer(String IP_address) {
        for (EnergyOffer offer : energyOffers) {
            if (offer.getEnergyAmount() > 0 && offer.owner.getIPAddress().equals(IP_address)) {
                return offer;
            }
        }
        return null;
    }

    public void trade() {
    	
        for (EnergyRequest request : new ArrayList<>(energyRequests)) {
        	Collections.sort(energyOffers);
            if (request.getPreference() == EnergyPreference.HIGH_PRICE) {
                Collections.reverse(energyOffers);
            }
            while (request.getEnergyAmount() > 0) {
                EnergyOffer offer = null;
                
                if (request.getPreferredIpAddress() != null) {
                	
                	offer = findOffer(request.getPreferredIpAddress());
                }
                
                if (offer == null) {
                    for (EnergyOffer offer1 : energyOffers) {
                        if (offer1.getEnergyAmount() > 0) { offer = offer1;
                            break;
                    }
                    }
                }
                if (offer == null) {
                    break;
                }
                
                int tradedAmount = Math.min(request.getEnergyAmount(), offer.getEnergyAmount());
                if (!createdTransaction(request, offer, tradedAmount)) {
                    break;
                }
                	request.decreaseEnergyAmount(tradedAmount);
                	offer.decreaseEnergyAmount(tradedAmount);
                 
                    if (offer.getEnergyAmount() == 0) {
                        energyOffers.remove(offer);
                    }
                    if (request.getEnergyAmount() == 0) {
                        energyRequests.remove(request);
                    }
                } 

          }
        
    }
    
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("---------------------------------------------\n");
            sb.append("Prosumers and Consumers:\n\n");
            for (Consumer consumerOrProsumer : this.consumers.values()) {
                sb.append(consumerOrProsumer.toString()).append("\n");
            }
            sb.append("\nCurrent Energy Requests:\n");
            for (EnergyRequest energyRequest : this.energyRequests) {
                sb.append(energyRequest.toString()).append("\n");
            }
            sb.append("\nCurrent Energy Offers:\n");
            for (EnergyOffer energyOffer : this.energyOffers) {
                sb.append(energyOffer.toString()).append("\n");
            }
            sb.append("\nTransactions:\n");
            for (Transaction transaction : this.transactions) {
                sb.append(transaction.toString()).append("\n");
            }
            sb.append("\nEnergy Market Balance: ").append(this.getMoneyEarned()).append("\n");
            sb.append("---------------------------------------------").append("\n");
            sb.append("End of simulation");
            return sb.toString();
        }
	
}
//
//private double balance = 0;


//
//public void trade(EnergyRequest energyRequest) {
//    // sort the energy offers based on the preference
//    Collections.sort(energyOffers);
//    if (energyRequest.getPreference() == EnergyPreference.HIGH_PRICE) {
//        Collections.reverse(energyOffers);
//   
	

