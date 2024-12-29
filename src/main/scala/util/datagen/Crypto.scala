package util.datagen

import com.github.javafaker.Faker

import scala.util.Random

trait Crypto {
  private val cryptoFaker = new Faker()
  // Predefined lists for cryptocurrencies and networks // Predefined lists for cryptocurrencies and networks
  val cryptoNames = List(
    "Bitcoin",
    "Ethereum",
    "Litecoin",
    "Ripple",
    "Cardano",
    "Solana",
    "Polkadot",
    "Dogecoin"
  )

  val cryptoNetworks = List(
    "Bitcoin Network",
    "Ethereum Network",
    "Binance Smart Chain",
    "Ripple Network",
    "Cardano Network"
  )

  val cryptoFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
      "coin_Feeder" -> Random.shuffle(cryptoNames).head,
      "wallet_Feeder" -> Random.shuffle(cryptoNetworks).head,
      "network_Feeder" -> cryptoFaker.crypto().sha256()
    )
  )}
}
