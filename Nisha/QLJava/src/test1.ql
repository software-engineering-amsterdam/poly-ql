form Box1HouseOwning {
hasSoldHouse: "Did you sell a house in 2010?" boolean
hasBoughtHouse: "Did you buy a house in 2010?" boolean
hasMainLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
if(hasSoldHouse == True) {
sellingPrice: "Price the house was sold for:" integer
privateDebt: "Private debts for the sold house:" integer
valueResidue: "Value residue:" integer(sellingPrice - privateDebt)
} 
else{
if(hasBoughtHouse == True) {
buyingPrice: "Price the house was bought for:" integer
privateDebt: "Private debts for the sold house:" integer
valueResidue: "Value residue:" integer(buyingPrice + privateDebt)
}
}
}
